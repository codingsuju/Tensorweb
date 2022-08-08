FROM ubuntu
RUN apt-get update -y 
RUN apt-get install nginx -y
COPY nginx.conf /etc/nginx/nginx.conf
EXPOSE 80:80 
CMD ["/usr/sbin/nginx", "-g", "daemon off;"]
